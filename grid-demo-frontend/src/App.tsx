import * as React from 'react';
import './App.css';

import logo from './logo.svg';
import {AgGridReact} from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-balham.css';
import {flatRoutesSelector} from "./reselect/dataSelector";
import {connect} from "react-redux";
import {GridState} from "./redux/GridState";

interface AppProps {
    flatRoutes: FlatRoute[]
}

interface Header {
    headerName: string,
    field: string,
    sortable: boolean,
    filter: boolean
}

interface AppState {
    columnDefs: Header[]
}

class App extends React.Component<AppProps, AppState> {

    constructor(props: any) {
        super(props);
        this.state = {
            columnDefs: [{
                headerName: "№", field: "num", sortable: true, filter: false
            }, {
                headerName: "Номер", field: "number", sortable: true, filter: true
            }, {
                headerName: "Дата", field: "date", sortable: true, filter: true
            }, {
                headerName: "СПЦ", field: "spcName", sortable: true, filter: true
            }, {
                headerName: "Адрес СПЦ", field: "spcAddress", sortable: true, filter: true
            }, {
                headerName: "Инкассатор", field: "collector", sortable: true, filter: true
            }, {
                headerName: "Автомобиль", field: "car", sortable: true, filter: true
            }]
        }
    }

    public render() {
        return (
            <div className="App"
                 style={{
                     height: "100%",
                 }}
            >
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">Welcome to React</h1>
                </header>
                <p className="App-intro">
                    To get started, edit <code>src/App.tsx</code> and save to reload.
                </p>
                <div
                    className="ag-theme-balham"
                    style={{
                        height: "600px",
                        width: "100%"
                    }}
                >
                    <AgGridReact
                        columnDefs={this.state.columnDefs}
                        rowData={this.props.flatRoutes}/>
                </div>
            </div>
        );
    }
}

const mapStateToProps = (state: GridState) => {
    const flatRoutes = flatRoutesSelector(state);

    return {
        flatRoutes
    }
};

const mapDispatchToProps = {};

export default connect(mapStateToProps, mapDispatchToProps)(App);

