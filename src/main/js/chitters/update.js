import React from 'react';


class Update extends React.Component {
    constructor(props) {
    super(props);
    this.state = {content: this.props.content}
    this.updateSubmit = this.updateSubmit.bind(this)

    }

 onChange(e){
        this.setState({content: e.target.value})
      }

updateSubmit() {
    var new_content = this.state.content;
    console.log(new_content)
    console.log(this.props);

     fetch('/api/chitters/'+ this.props.chitter.chitter_id + '/', {
        method: "PUT",
        body: JSON.stringify(new_content),
         headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      }).then(response => {
          this.props.setchitter();
          console.log("update successful");
      })
   }

  clearSubmit() {
      this.props.toggleUpdate();
    }


render(){
    return(
        <div>
                <textarea id="updateChitter" value={this.state.content} onChange={(e) => this.onChange(e)}>
                </textarea>
                <button onClick={() => this.updateSubmit()} >Update</button>
                <button onClick={() => this.clearSubmit()} >Clear</button>
              </div>
    )

 }


}
export default Update;