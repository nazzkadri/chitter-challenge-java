import React from 'react';
import Chitters from './chitters'
import CreateChitter from './createChitter'

const client = require('../client');

class ChittersBuilder extends React.Component {

    constructor(props){
        super(props)
        this.state = {chitters: []};
        this.setNewChitter = this.setNewChitter.bind(this);
    }
    componentDidMount(){
        this.setNewChitter();
    }

    setNewChitter(){

//        client({method: 'GET', path: '/api/chitters'}).then(response => {
//            this.setState({chitters: response.entity._embedded.chitters.reverse});
//    })

    client({method: 'GET', path: '/api/chitters'}).then(response => {
                console.log(response);

              //this.setState({chitters: response.entity });
              this.setState({chitters: response.entity});

              })
              .catch(function (error) {
                                    console.log(error)
                                  });

    }

    render(){
    return(
        <div>
        <Chitters chitters={this.state.chitters} setchitter={this.setNewChitter}/>
        <CreateChitter setchitter = {this.setNewChitter}/>
        </div>
    )

    }
}

export default ChittersBuilder;