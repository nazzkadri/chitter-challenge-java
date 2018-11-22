import React from 'react';
const client = require('../client');


class Comment extends React.Component {
    constructor(props) {
        super(props)
         this.id =this.props.chitterId
            console.log(this.id)
        this.state = {comment_content: ""}
        console.log("im in comment")
        this.handleCmtSubmit = this.handleCmtSubmit.bind(this);
        this.onChange = this.onChange.bind(this);
    }

    onChange(event){
            this.setState({comment_content: event.target.value})
          }

    componentDidUpdate(){
         let that = this;
            that.props.setchitter();
    }

    handleCmtSubmit(event) {
            event.preventDefault();
            let that = this;
            fetch('/api/chitters/'+ that.id+'/comments', {
                method: 'POST',
                headers: {
                    'content-type': 'application/json'
                },
                body: JSON.stringify({
                    comment_content: that.state.comment_content
                })
            }).then(() => {
                console.log(that.state.comment_content);

                that.setState({
                    comment_content: ""
                });
                console.log(that.state.comment_content);
            }).catch(function (error) {
                    console.log(error);
                  });
        }


    render(){
        return(
             <form onSubmit={this.handleCmtSubmit} className='comment-form'>

        <textarea id="newComment" name='comment_content' value={this.state.comment} className='comment-box' onChange={(e) => this.onChange(e)}/>
                                  <br />
                                  <button className='post-btn'>Comment</button>
                              </form>

        )
    }
}

export default Comment;