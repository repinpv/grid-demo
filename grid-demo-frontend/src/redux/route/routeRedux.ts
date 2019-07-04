import {Action} from "redux";
import {Route} from "./routesInterfaces";

export enum ActionType {
    SET_ROUTES,
}

export interface SetRoutesAction extends Action<ActionType> {
    type: ActionType;
    routes: Route[];
}

export function setRoutes(routes: Route[]): SetRoutesAction {
    return {
        type: ActionType.SET_ROUTES,
        routes,
    };
}

export interface RouteState {
    routes: Route[];
}

const initialState: RouteState = {
    routes: []
};

export function routeReducer(state = initialState, action: Action<ActionType>): RouteState {

    switch (action.type) {
        case ActionType.SET_ROUTES:
            const setRoutesAction = action as SetRoutesAction;
            return {
                ...state,
                routes: setRoutesAction.routes
            };
    }

    return state;
}