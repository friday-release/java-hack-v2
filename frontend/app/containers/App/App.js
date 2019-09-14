/**
 *
 * App
 *
 * This component is the skeleton around the actual pages, and should only
 * contain code that should be seen on all pages. (e.g. navigation bar)
 */

import React from 'react';
import { Helmet } from 'react-helmet';
import { Switch, Route } from 'react-router-dom';

import HomePage from 'containers/HomePage/Loadable';
import FeaturePage from 'containers/FeaturePage/Loadable';
import NotFoundPage from 'containers/NotFoundPage/Loadable';
import Header from 'components/Header';
import Footer from 'components/Footer';
import LeftSideBar from 'components/LeftSideBar';
import './style.scss';

const App = () => (
  <div className="layout">
    {/* <LeftSideBar /> */}
    {/* <Header /> */}
    <Switch>
      <Route exact path="/" component={HomePage} />
      <Route path="/features" component={FeaturePage} />
      <Route path="" component={NotFoundPage} />
    </Switch>
  </div>
);

export default App;
