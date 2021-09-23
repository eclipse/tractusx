const DescriptionList = (props) => {
  return(
    <dl>
      <dt className='dib minw150 fs14 fggrey'>{props.title}</dt>
      <dd className='fs14 fg5a dib'>{props.description}</dd>
    </dl>
  )
}

export default DescriptionList;
