const React = require('react');
 const ReactDOM = require('react-dom');
import ChittersBuilder from './chitters/chittersBuilder'
import SignUpForm from './signup/signupForm'

class App extends React.Component {

render(){
return(
<React.Fragment>
                <div>
                    <SignUpForm/>
                </div>

                <div>
                    <ChittersBuilder/>
                </div>
            </React.Fragment>

)
}
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)
