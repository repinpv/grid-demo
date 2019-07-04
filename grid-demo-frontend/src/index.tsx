import * as React from 'react';
import * as ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import {Provider} from "react-redux";
import {applyMiddleware, combineReducers, createStore} from "redux";
import thunkMiddleware, {ThunkDispatch} from "redux-thunk";
import {routeReducer, SetRoutesAction} from "./redux/route/routeRedux";
import {routeFilterReducer} from "./redux/route/filter/routeFilterRedux";
import {loadRoutes} from "./thunk/loadRoutes";
import {Route} from "./redux/route/routesInterfaces";

const appliedMiddleware = applyMiddleware(thunkMiddleware);
const store = createStore(combineReducers({
    routeState: routeReducer,
    routeFilterState: routeFilterReducer,
}), appliedMiddleware);

(store.dispatch as ThunkDispatch<Route[], undefined, SetRoutesAction>)(loadRoutes());

ReactDOM.render(
    <Provider store={store}>
        <App/>
    </Provider>,
    document.getElementById('root') as HTMLElement
);
registerServiceWorker();
