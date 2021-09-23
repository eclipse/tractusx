import { Icon } from "@fluentui/react";
import { observer } from "mobx-react";
import React from "react";

@observer
export default class BackLink extends React.Component<{ history: any }>{

  backClick(history) {
    if (history.length > 1) {
      history.goBack();
    } else {
      history.push('/home/dashboard');
    }
  }
  public render() {
    return (
      <div className='fgblack fs15 fw600 df mt10 mb20 aic cpointer' onClick={() => this.backClick(this.props.history)}>
        <Icon className='fgblack fs20 mt2 mr7' iconName='SkypeArrow' />
        BACK
      </div>
    );
  }
}
