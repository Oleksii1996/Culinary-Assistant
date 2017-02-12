import React from 'react';
import './Container.css';

const FindRecipe = React.createClass({
	getInitialState: function() {
		return {
			text: ""
		};
	},

	handleInput: function(e) {
		this.setState({
			text: e.target.value
		});
	},

	handleFind: function() {
		var request = this.state.text.split('\n');
		request = JSON.stringify(request);
		console.log(request);
		
		/*axios.get('/recipe', request)
  		.then(function (response) {
    		console.log(response);
  		})
  		.catch(function (error) {
    		console.log(error);
  		});*/
	},

	render: function() {
		return (
			<div className='container'>
				<h1>Find</h1>
				<center>
					<textarea 
						placeholder='Input recipe here' 
						rows='10' 
						onInput={this.handleInput}
					/>
					<button 
						className='btn btn-default' 
						onClick={this.handleFind}>
					Find
					</button>
				</center>
			</div>
		);
	}
});

export default FindRecipe;