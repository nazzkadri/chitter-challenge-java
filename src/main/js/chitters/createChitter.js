import React from 'react';
const client = require('../client');


class CreateChitter extends React.Component {
    constructor(props) {
        super(props)
        this.handleSubmit = this.handleSubmit.bind(this)
    }



    handleSubmit(event) {
        event.preventDefault();
      let newChitter = document.getElementById("newChitter").value;
      fetch('api/chitters', {
        method: "POST",
        body: JSON.stringify(newChitter),
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      }).then(response => {
        response.json().then(data => {
        console.log("im in post response method")
          this.props.setchitter()
          console.log("Chitter successful" + JSON.stringify(data));
        })
      })

  }

  render () {
      return(

       <form onSubmit={this.handleSubmit} className='chitter-form'>
                      <h1 className='submit-text'>Write your chit here</h1>
                      <textarea id="newChitter" className='text-box' />
                      <br />
                      <button className='post-btn'>Chit</button>
                  </form>


      )
    }
}
export default CreateChitter;