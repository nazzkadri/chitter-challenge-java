import React from 'react';
const client = require('../client');


class SignUpForm extends React.Component {
    constructor(props) {
        super(props);
        this.handleChangeName = this.handleChangeName.bind(this);
        this.handleChangeUserName = this.handleChangeUserName.bind(this);
            this.handleChangeEmail = this.handleChangeEmail.bind(this);
            this.handleChangePassword = this.handleChangePassword.bind(this);
            this.handleSubmit = this.handleSubmit.bind(this);
            this.state = {
                fullname: '',
                username: '',
                password: '',
                email: ''
            }
        }

handleChangeName(event) {
        this.setState({
            fullname: event.target.value
        });
    }

handleChangeUserName(event) {
        this.setState({
            username: event.target.value
        });
    }
    handleChangeEmail(event){
        this.setState({
            email: event.target.value
        });
    }

    handleChangePassword(event){
        this.setState({
            password: event.target.value
        });
    }

 handleSubmit(event){
        event.preventDefault();
        fetch("/api/users", {
            method: "POST",
            headers: {
                "content-type": "application/json"
            },
            body: JSON.stringify({
                username: this.state.username,
                fullname: this.state.fullname,
                email: this.state.email,
                password: this.state.password
            })
        })
    }
     render(){
        return(
          <form className='sign-up-form' onSubmit={this.handleSubmit}>
                         <h1 className='sign-up-text'>Sign up</h1>
                         <input type='text' onChange={this.handleChangeName} value={this.state.fullname} placeholder='FullName' required/>
                         <input type='text' onChange={this.handleChangeUserName} value={this.state.username} placeholder='UserName' required/>
                         <input type='email' onChange={this.handleChangeEmail} value={this.state.email} placeholder='Email' required/>
                         <input type='password' onChange={this.handleChangePassword} value={this.state.password} placeholder='Password' required/>
                         <button>Submit</button>
                     </form>
        )

     }



     }

     export default SignUpForm;