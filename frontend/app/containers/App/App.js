/**
 *
 * App
 *
 * This component is the skeleton around the actual pages, and should only
 * contain code that should be seen on all pages. (e.g. navigation bar)
 */

import React from 'react';
import { Switch, Route } from 'react-router-dom';

import Header from 'components/Header';
import HomePage from 'containers/HomePage/Loadable';
import './style.scss';

const App = () => (
  <div className="layout">
    {/* <LeftSideBar /> */}
    <Header/>
    <Switch>
      <Route exact path="/" component={HomePage} />
    </Switch>
  </div>
);

export default App;
