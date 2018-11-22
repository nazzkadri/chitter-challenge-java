import React from 'react';
import Update from './update.js'
import Comment from '../comments/comment.js'
import UpdateBtn from './updateBtn.js'


class Chitter extends React.Component {
    constructor(props) {
    super(props);
    console.log(this.props.chitter.chitter_id)
    this.state = {showUpdate: false};
    this.toggleUpdate = this.toggleUpdate.bind(this);
    this.onDelete = this.onDelete.bind(this)
    }

toggleUpdate() {
		var showUpdate = this.state.showUpdate
		this.setState({
			showUpdate: showUpdate == false ? true : false
		})
	}

onDelete() {

     fetch('/api/chitters/'+ this.props.chitter.chitter_id + '/', {
        method: "DELETE",
         headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      }).then(response => {
          this.props.setchitter();
          console.log("delete successful");
      })
   }

    render(){
    let date = new Date(this.props.chitter.createdAt).toString();
    console.log(date)
    if (this.state.showUpdate == true) {
    			return (
    				<div className='chitter-main'>
    					<Update content={this.props.chitter.content} setchitter={this.props.setchitter} chitter={this.props.chitter} toggleUpdate={this.toggleUpdate} />
    				</div>
    			)
    		} else {
    return(
        <div className='chitter-main'>
            <div className='chitter-content'>
                        {this.props.chitter.content}
            </div>
            <div>{date}</div>
         <div>{this.props.chitter.commentList}</div>
             <div className="delete-btn">
                            <br />
                            <UpdateBtn toggleUpdate={this.toggleUpdate}/>
                            <button onClick={this.onDelete} className="del-btn">Delete this chit     <i className="fas fa-trash-alt"></i></button>
                        </div>

        </div>
        )
    }
}
}
export default Chitter;