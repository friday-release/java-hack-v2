import React from 'react';
import './style.scss';

class LeftSideBar extends React.Component { // eslint-disable-line react/prefer-stateless-function
  render() {
    return (
     <left-sidebar className="left-sidebar">
       <nav className="left-sidebar__nav">
         <a className="left-sidebar__item left-sidebar__item_active" routerlink="/cards" routerlinkactive="left-sidebar__item_active" href="#/cards"><icon-cards className="left-sidebar__icon icon"><div className="rc-icon-svg rc-icon-svg_cards rc-icon-svg_active rc-icon-svg_to-active rc-icon-svg_cards-to-active"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><g fill="currentColor" fillRule="evenodd"><path d="M6 20h16v-8H6v8zm0-10h16V8H6v2zm16.093-4H5.907A1.909 1.909 0 0 0 4 7.907v12.186C4 21.145 4.855 22 5.907 22h16.186A1.909 1.909 0 0 0 24 20.093V7.907A1.909 1.909 0 0 0 22.093 6z"></path><path d="M16 16h4v-2h-4zM2 18h-.093A1.909 1.909 0 0 1 0 16.093V3.907C0 2.855.855 2 1.907 2h16.186C19.145 2 20 2.855 20 3.907l-1.933.09a.109.109 0 0 0 .026.003H2v12.093A.093.093 0 0 0 1.907 16L2 18z"></path></g></svg></div></icon-cards><span className="left-sidebar__label">Карты</span></a>
         <a className="left-sidebar__item" routerlink="/accounts" routerlinkactive="left-sidebar__item_active" href="#/accounts"><icon-accounts className="left-sidebar__icon icon"><div className="rc-icon-svg rc-icon-svg_accounts"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><g fill="currentColor" fillRule="evenodd"><path d="M5 5v18h16v-7h-2v5H7V7h12v9h2V5z"></path><path d="M1 1v18h2V3h14V1z"></path><path d="M9 12h6v-2H9zM9 16h6v-2H9z"></path></g></svg></div></icon-accounts><span className="left-sidebar__label">Счета</span></a>
         <a className="left-sidebar__item" routerlink="/goals" routerlinkactive="left-sidebar__item_active" href="#/goals"><icon-goal className="left-sidebar__icon icon"><div className="rc-icon-svg rc-icon-svg_goal"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><g fill="currentColor" fillRule="evenodd"><path d="M12 8c-2.21 0-4 1.79-4 4s1.79 4 4 4 4-1.79 4-4-1.79-4-4-4zm8.94 3A8.994 8.994 0 0 0 13 3.06V1h-2v2.06A8.994 8.994 0 0 0 3.06 11H1v2h2.06A8.994 8.994 0 0 0 11 20.94V23h2v-2.06A8.994 8.994 0 0 0 20.94 13H23v-2h-2.06zM12 19c-3.87 0-7-3.13-7-7s3.13-7 7-7 7 3.13 7 7-3.13 7-7 7z"></path></g></svg></div></icon-goal><span className="left-sidebar__label">Цели</span></a>
         <a className="left-sidebar__item" routerlink="/deposits" routerlinkactive="left-sidebar__item_active" href="#/deposits"><icon-deposit className="left-sidebar__icon icon"><div className="rc-icon-svg rc-icon-svg_deposit"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><g fill="none" fillRule="evenodd"><path d="M-30-16h84v80h-84z"></path><path d="M18 15h2v5h2v-5h2l-3-4z" fill="currentColor"></path><path d="M0 4v14h17v-2H2V6h20v3.25h2V4z" fill="currentColor"></path><g transform="translate(0 4)"><path d="M11 6c-.551 0-1 .449-1 1 0 .551.449 1 1 1h2c.551 0 1-.449 1-1 0-.551-.449-1-1-1h-2zm2 4h-2c-1.654 0-3-1.346-3-3s1.346-3 3-3h2c1.654 0 3 1.346 3 3s-1.346 3-3 3z" fill="currentColor"></path><path d="M4 6h2V4H4z" fill="currentColor"></path></g></g></svg></div></icon-deposit><span className="left-sidebar__label">Вклады</span></a>
         <a className="left-sidebar__item" routerlink="/loans" routerlinkactive="left-sidebar__item_active" href="#/loans"><icon-loan className="left-sidebar__icon icon"><div className="rc-icon-svg rc-icon-svg_loan"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><g fill="currentColor" fillRule="nonzero"><path d="M24 23H0V9h11v2H2v10h20v-8h2z"></path><path d="M13 19h-2a3 3 0 0 1 0-6h2a3 3 0 0 1 0 6zm-2-4a1 1 0 0 0 0 2h2a1 1 0 0 0 0-2h-2zM4 13h2v2H4zM18 17h2v2h-2zM18 13a6 6 0 1 1 0-12 6 6 0 0 1 0 12zm0-10a4 4 0 1 0 0 8 4 4 0 0 0 0-8z"></path><path d="M18.96 9.37L17 7.41V4.5h2v2.09l1.37 1.37zM0 5h11v2H0z"></path></g></svg></div></icon-loan><span className="left-sidebar__label">Кредиты</span></a>
         <a className="left-sidebar__item" routerlink="/uits" routerlinkactive="left-sidebar__item_active" href="#/uits"><icon-uit className="left-sidebar__icon icon"><div className="rc-icon-svg rc-icon-svg_uit"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><g fill="currentColor" fillRule="evenodd"><path d="M20 12a8 8 0 1 1-8-8l.659-1.976A10.019 10.019 0 0 0 12 2C6.477 2 2 6.477 2 12s4.477 10 10 10 10-4.477 10-10c0-.222-.01-.44-.024-.659L20 12z"></path><path d="M15 9l1.257-3.772a8.042 8.042 0 0 1 2.515 2.515L15 9zm5.713-1.904a10.04 10.04 0 0 0-3.809-3.809 9.979 9.979 0 0 0-1.742-.772l-.632 1.896L12 12l7.59-2.53 1.895-.632a9.979 9.979 0 0 0-.772-1.742z"></path></g></svg></div></icon-uit><span className="left-sidebar__label">ПИФы</span></a>
         <a className="left-sidebar__item ng-star-inserted" routerlink="/children" routerlinkactive="left-sidebar__item_active" href="#/children"><div className="left-sidebar__item-star"></div><div className="left-sidebar__item-star"></div><div className="left-sidebar__item-star"></div><icon-child className="left-sidebar__icon icon"><div className="rc-icon-svg rc-icon-svg_child"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><g fill="currentColor"><path d="M12,1.5 A11,11 0 0 0 1.0000000000000002,12.5 L1.0000000000000002,18.5 L5.35,18.5 A7.8100000000000005,7.8100000000000005 0 0 0 12,22.5 A7.8100000000000005,7.8100000000000005 0 0 0 18.65,18.5 L23,18.5 L23,12.5 A11,11 0 0 0 12,1.5 zM21,16.5 L19.530000000000005,16.5 A9.86,9.86 0 0 0 20,13.5 L18,13.5 C18,17.36 15.31,20.5 12,20.5 S6,17.36 6,13.5 L4,13.5 A9.86,9.86 0 0 0 4.4700000000000015,16.5 L3,16.5 L3,12.5 A9,9 0 0 1 21,12.5 L21,16.5 z"></path><path d="M12.000000417232513,18.5 A3,3 0 0 0 15.000000417232513,15.5 L9.000000417232513,15.5 A3,3 0 0 0 12.000000417232513,18.5 z"></path><path d="M13.839999940395355,5.18 L13.239999940395355,5.8 C12.499999940395355,6.55 10.069999940395356,8.5 7.7299999403953565,8.5 A7,7 0 0 1 4.999999940395355,7.94 L4.999999940395355,10.08 A9.17,9.17 0 0 0 7.7299999403953565,10.5 C10.479999940395356,10.5 12.939999940395355,8.71 14.049999940395356,7.76 A9,9 0 0 0 18.999999940395355,8.99 L18.999999940395355,6.99 A7.16,7.16 0 0 1 14.539999940395354,5.69 L13.839999940395355,5.18 z"></path><circle cx="7.999999940395355" cy="12.5" id="svg_4" r="1" strokeDasharray="none"></circle><circle cx="15.999999940395355" cy="12.5" id="svg_5" r="1" strokeDasharray="none"></circle></g></svg></div></icon-child><span className="left-sidebar__label">Старт</span></a>
         </nav>
        </left-sidebar>
    );
    // return (
    //   <div className="header">
    //     <a href="https://twitter.com/flexdinesh">
    //       <img src={Banner} alt="react-redux-boilerplate - Logo" />
    //     </a>
    //     <div className="nav-bar">
    //       <Link className="router-link" to="/">
    //         Home
    //       </Link>
    //       <Link className="router-link" to="/features">
    //         Features
    //       </Link>
    //     </div>
    //   </div>
    // );
  }
}

export default LeftSideBar;
