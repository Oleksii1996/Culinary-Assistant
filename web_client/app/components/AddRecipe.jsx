import React from 'react';
import axios from 'axios';
import './Container.css';

const AddRecipe = React.createClass({
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

	handleAdd: function() {
		var request = this.state.text.split('\n');
		request = JSON.stringify(request);
		console.log(request);
		
		/*axios.post('/recipe', request)
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
				<h1>Add</h1>
				<center>
					<textarea 
						placeholder='Input recipe here' 
						rows='10' 
						onInput={this.handleInput}
					/>
					<button 
						className='btn btn-default' 
						onClick={this.handleAdd}>
					Add
					</button>
				</center>
			</div>
		);
	}
});

export default AddRecipe;