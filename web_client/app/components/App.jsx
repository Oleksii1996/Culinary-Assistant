import React from 'react';
import Menu from './Menu.jsx';
import MainPage from './MainPage.jsx';
import AddRecipe from './AddRecipe.jsx';
import FindRecipe from './FindRecipe.jsx';

var App = React.createClass({
	getInitialState: function() {
		return {
			displayedPage: <MainPage />
		};
	},

	changeDisplayedPage: function(data) {
		switch (data) {
			case "MAIN_PAGE":
				this.setState({
					displayedPage: <MainPage />
				});
			break;

			case "ADD_RECIPE":
				this.setState({
					displayedPage: <AddRecipe />
				});
			break;

			case "FIND_RECIPE": 
				this.setState({
					displayedPage: <FindRecipe />
				});
			break;
		}
	},

	render: function() {
		return (
			<div>
			{
				this.state.displayedPage
			}
			<Menu display={this.changeDisplayedPage}/>
			</div>
		);
	}
});

export default App;