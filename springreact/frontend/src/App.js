
import React, {Component} from "react";
import './App.css';
import Home from './Home';
import ClientList from './ClientList';
import ClientEdit from './ClientEdit';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

class App extends Component {
  render() {
    return (
        <Router forceRefresh={true}>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/clients' exact={true} component={ClientList}/>
            <Route path='/clients/:id' component={ClientEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;
