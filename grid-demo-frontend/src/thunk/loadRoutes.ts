import axios from 'axios'
import {Route} from "../redux/route/routesInterfaces";
import {setRoutes, SetRoutesAction} from "../redux/route/routeRedux";
import {ThunkAction} from "redux-thunk";

export function loadRoutes(): ThunkAction<void, Route[], undefined, SetRoutesAction> {
    return (dispatch): void => {
        axios.get('http://localhost:8080/routes')
            .then(response => {
                console.log(response);
                dispatch(setRoutes(response.data));
            })
            .catch(reason => {
                console.log(reason);
            });
    };
}

// export const loadRoutes: ActionCreator<ThunkAction<AnyAction, any, undefined, AnyAction>> = () => {
//     return (dispatch: Dispatch<any>): void => {
//         axios.get<Array<Route>>('https://localhost:8080/routes')
//             .then((response) => {
//                 dispatch(setRoutes(response.data))
//             });
//     };
// };