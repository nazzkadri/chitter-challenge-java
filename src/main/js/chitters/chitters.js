import React from 'react';
import Chitter from './chitter';
import Comment from '../comments/comment.js'


class Chitters extends React.Component {
  constructor(props) {
    super(props);
  }

	render() {
		return (

      <article className='chitters-main'>
      <h1 className='chitters-title'>Posts</h1>
        <div className='chitters-items'>
            {this.getChitters()}
        </div>
      </article>
		)
	}


getChitters() {
    return this.props.chitters.map(chitter => {
    return (
             <div>
			<Chitter key={chitter} chitter={chitter} setchitter = {this.props.setchitter}/>
		<Comment chitterId={chitter.chitter_id} setchitter={this.props.setchitter} chitter={chitter}/>
			</div>
			)
		});
  }
}

export default Chitters;
