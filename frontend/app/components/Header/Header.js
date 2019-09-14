import React from 'react';
import { Link } from 'react-router-dom';
import Banner from './images/banner.jpg';
import './style.scss';

class Header extends React.Component { // eslint-disable-line react/prefer-stateless-function
  render() {
    return (
      <div className="top-sidebar">
        <div className="top-sidebar__content">
          <a className="top-sidebar__logo" routerlink="/favourites" href="#/favourites"></a>
          <div className="top-sidebar__header">
            <div className="top-sidebar__header-left-side">
              <nav className="top-sidebar__navigation">
                <a className="top-sidebar__navigation-item" routerlink="/history/operations" href="#/history/operations">
                  <span className="top-sidebar__navigation-item-label">История операций</span>
                  </a>
                  <a className="top-sidebar__navigation-item" routerlink="/templates" routerlinkactive="top-sidebar__navigation-item_active" href="#/templates">
                    <span className="top-sidebar__navigation-item-label">Шаблоны и автоплатежи</span>
                  </a>
              </nav>
            </div>
          </div>
          <div className="top-sidebar__body">
              <nav className="actions-menu">
                <a className="actions-menu__item" routerlink="/favourites" routerlinkactive="actions-menu__item_active" href="#/favourites">
                  <span className="actions-menu__item-label">Избранное</span></a>
                <a className="actions-menu__item actions-menu__item_transfer" routerlink="/transfer" routerlinkactive="actions-menu__item_active" href="#/transfer">
                <span className="actions-menu__item-label">Перевести</span></a>
                <a className="actions-menu__item actions-menu__item_payment" routerlink="/payment" routerlinkactive="actions-menu__item_active" href="#/payment">
                <span className="actions-menu__item-label">Оплатить</span></a>
                <a className="actions-menu__item actions-menu__item_recharge" routerlink="/recharge" routerlinkactive="actions-menu__item_active" href="#/recharge"><icon-recharge className="icon"><div className="rc-icon-svg rc-icon-svg_recharge"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><g fill="currentColor" fillRule="evenodd"><path d="M11 16l3-4h-2V2h-2v10H8z"></path><path d="M20 6h-6v2h6v2h-4v2h4v8H4v-8h2v-2H4V8h4V6H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2"></path></g></svg></div></icon-recharge><span className="actions-menu__item-label">Пополнить</span></a>
                <a className="actions-menu__item actions-menu__item_exchange" routerlink="/exchange" routerlinkactive="actions-menu__item_active" href="#/exchange"><icon-exchange className="icon"><div className="rc-icon-svg rc-icon-svg_exchange"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><g fill="currentColor" fillRule="evenodd"><path d="M2.024 12.659L4 12a8 8 0 0 1 8-8l.659-1.976A10 10 0 0 0 12 2C6.477 2 2 6.477 2 12c0 .221.01.44.024.658zM21.976 11.342L20 12a8 8 0 0 1-8 8l-.659 1.976A10 10 0 0 0 12 22c5.523 0 10-4.477 10-10 0-.221-.01-.44-.024-.658M17 10c-.551 0-1-.449-1-1h-2c0 1.303.837 2.412 2 2.825V13h2v-1.175A3.003 3.003 0 0 0 20 9c0-1.654-1.346-3-3-3a1.001 1.001 0 0 1 0-2c.551 0 1 .449 1 1h2a3.003 3.003 0 0 0-2-2.825V1h-2v1.175A3.003 3.003 0 0 0 14 5c0 1.654 1.346 3 3 3a1.001 1.001 0 0 1 0 2M9.119 15.876l1.414-1.414a5.006 5.006 0 0 0-7.071 0 5.006 5.006 0 0 0 0 7.071 4.985 4.985 0 0 0 3.536 1.462c1.28 0 2.56-.487 3.535-1.462L9.119 20.12a3.004 3.004 0 0 1-4.243 0 2.974 2.974 0 0 1-.703-1.121H7v-2H4.173c.144-.41.376-.795.703-1.122a3.004 3.004 0 0 1 4.243 0"></path></g></svg></div></icon-exchange><span className="actions-menu__item-label">Обменять</span></a>
                <a className="actions-menu__item actions-menu__item_open" routerlink="/open" routerlinkactive="actions-menu__item_active" href="#/open"><open-icon className="open-icon"><icon-card className="icon"><div className="rc-icon-svg rc-icon-svg_card"><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M16 18h4v-8H4v8h12zm0 2H4a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2h-4zM7 6H4v2h16V6H7zm7 6h4v2h-4v-2z" fill="currentColor" fillRule="evenodd"></path></svg></div></icon-card><span className="open-icon__count ng-star-inserted">2</span></open-icon><span className="actions-menu__item-label">Открыть</span></a>
              </nav>
            </div>
        </div>
        </div>
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

export default Header;
