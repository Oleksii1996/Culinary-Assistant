import React from 'react';
import './Menu.css';

const Menu = React.createClass({
	handleMainPage: function() {
		this.props.display("MAIN_PAGE");
	},

	handleAddRecipe: function() {
		this.props.display("ADD_RECIPE");
	},

	handleFindRecipe: function() {
		this.props.display("FIND_RECIPE");
	},

	render: function() {
		return (
			<div className='Menu'>
				<button className='btn btn-primary btn-large' onClick={this.handleMainPage}>Main</button><br />
				<button className='btn btn-primary btn-large' onClick={this.handleAddRecipe}>Add</button><br />
				<button className='btn btn-primary btn-large' onClick={this.handleFindRecipe}>Find</button><br />
			</div>
		);
	}
});

export default Menu;