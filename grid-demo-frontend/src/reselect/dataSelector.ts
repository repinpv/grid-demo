import {GridState} from "../redux/GridState";
import {createSelector} from "reselect";
import {Route} from "../redux/route/routesInterfaces";
import {RouteState} from "../redux/route/routeRedux";

export const routesSelector = (state: GridState) => state.routeState;

export const flatRoutesSelector = createSelector([routesSelector], (routeState: RouteState) => {
    const flatRoutes: FlatRoute[] = routeState.routes.map<FlatRoute>(
        (route: Route, index: number) => ({
            num: index + 1,
            number: route.number,
            date: route.date,
            spcName: route.spc.name,
            spcAddress: route.spc.address,
            collector: route.collector.name,
            car: route.car.name,
        }));
    return flatRoutes;
});