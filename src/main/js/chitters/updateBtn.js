import React from 'react';

const UpdateBtn = (props) => {
  return(
    <button onClick={() => props.toggleUpdate()}>Update</button>
  )
}

export default UpdateBtn;