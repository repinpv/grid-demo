import {Action} from "redux";
import {ActionType} from "./routeFilterRedux";

export class ContainsFilterAction implements Action<ActionType> {
    public type: ActionType;
    public substring: string;
}
