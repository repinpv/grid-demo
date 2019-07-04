import {Action} from "redux";
import {ContainsFilterAction} from "./ContainsFilterAction";

export enum ActionType {
    CLEAR_ROUTES_FILTER,
    SET_ROUTES_NUMBER_FILTER,
}

export function clearRouteFilter(): Action<ActionType> {
    return {
        type: ActionType.CLEAR_ROUTES_FILTER,
    };
}

export function setRouteNumberFilter(numberSubstring: string): ContainsFilterAction {
    return {
        type: ActionType.SET_ROUTES_NUMBER_FILTER,
        substring: numberSubstring,
    };
}

class RouteFilterState {
    public numberSubstring: string;
}

const initialState: RouteFilterState = {
    numberSubstring: ""
};

export function routeFilterReducer(
    state: RouteFilterState = initialState,
    action: Action<ActionType>
): RouteFilterState {

    switch (action.type) {
        case ActionType.SET_ROUTES_NUMBER_FILTER:
            const containsFilterAction = action as ContainsFilterAction;
            return {
                ...state,
                numberSubstring: containsFilterAction.substring
            };

        case ActionType.CLEAR_ROUTES_FILTER:
            return {
                ...initialState
            };
    }

    return state;
}