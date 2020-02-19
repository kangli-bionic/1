import React, { Component } from 'react';
import '../style/App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import FizzBuzz from './FizzBuzz';

class App extends Component {

  render() {
    return (
      <Router>
        <Route path='/' exact={true} component={FizzBuzz}/>
      </Router>
    )
  }
}

export default App;