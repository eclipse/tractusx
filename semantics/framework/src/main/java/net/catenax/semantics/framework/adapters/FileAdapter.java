/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.adapters;

import net.catenax.semantics.framework.*;
import net.catenax.semantics.framework.config.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;

/**
 * An adapter sitting on a URL-based filesystem
 * May either point to a single file or to a directory
 * containing (parameter-indexed) files.
 */
@Service
public class FileAdapter<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation>
    extends BaseAdapter<Cmd,O,Ct,Co,T> implements BackendAdapter {

    public static byte[] UTF8_BOM = new byte[] {(byte)0xEF, (byte)0xBB, (byte)0xBF};
    public static byte[] UTF16BE_BOM = new byte[] {(byte)0xFE, (byte)0xFF};
    public static byte[] UTF16LE_BOM = new byte[] {(byte)0xFE, (byte)0xFE};
    public static byte[] UTF32BE_BOM = new byte[] {(byte)0x00, (byte)0x00, (byte)0xFE, (byte)0xFF};
    public static byte[] UTF32LE_BOM = new byte[] {(byte)0xFF, (byte)0xFE, (byte)0x00, (byte)0x00};

    @Override
    public String getProtocol() {
        return "FILE";
    }

    public FileAdapter(Config<Cmd,O,Ct,Co,T> configurationData) {
        super(configurationData);
    }

    @Override
    public IdsMessage perform(IdsRequest request, String model) throws StatusException {
        String file = request.getParameters().get("file");
        String command = request.getCommand();
        if(configurationData.getCommands().containsKey(command)) {
            Command co = configurationData.getCommands().get(command);
            file=co.getFile();
            model=co.getModel();
        }

        BaseIdsMessage response = new BaseIdsMessage();

        if(file.endsWith("xml")) {
            response.setMediaType("text/xml");
        } else if (file.endsWith("json")) {
            response.setMediaType("application/json");
        }
        response.setModel(model);

        log.info("Accessing FILE source "+file+ " under assumed model "+model+" and media type "+response.getMediaType());

        InputStream inputStream=null;
        try {
            if (file.startsWith("classpath:")) {
                String resFile = file.substring(10);
                Resource res=new ClassPathResource(resFile,getClass().getClassLoader());
                if(!res.exists()) {
                    res=new ClassPathResource(resFile,getClass().getClassLoader().getParent());
                    if(!res.exists()) {
                        res = new ClassPathResource(resFile, Thread.currentThread().getContextClassLoader());
                        if (!res.exists()) {
                            throw new IOException("Could not find " + resFile + " in the classloader environment.");
                        }
                    }
                }
                inputStream = res.getInputStream();
            } else {
                inputStream = new URL(file).openStream();
            }
            byte[] firstBytes=new byte[6];
            int bom_index=0;
            firstBytes[bom_index]=(byte) inputStream.read();
            while(bom_index<UTF8_BOM.length && firstBytes[bom_index]==UTF8_BOM[bom_index]) {
                firstBytes[++bom_index]=(byte) inputStream.read();
            }
            String prePend="";
            // was the BOM met? NO, then read until we have enough bytes
            if(bom_index<UTF8_BOM.length) {
                if(bom_index%2==0) {
                    firstBytes[++bom_index]=(byte) inputStream.read();
                    prePend=new String(firstBytes,0,bom_index+1);
                }
            }
            try (BufferedReader resourceStream = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder contentBuilder = new StringBuilder(prePend);
                String sCurrentLine;
                while ((sCurrentLine = resourceStream.readLine()) != null) {
                    contentBuilder.append(sCurrentLine).append("\n");
                }
                response.setPayload(contentBuilder.toString());
            } finally {
            }
        } catch(IOException e) {
            log.error("Could not access FILE source "+file,e);
            throw new StatusException("Could not access FILE source "+file,e);
        }
        return response;
    }
}
