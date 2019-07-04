export interface Spc {
    id: number;
    name: string;
    address: string;
}

export interface Collector {
    id: number;
    name: string;
}

export interface Car {
    id: number;
    name: string;
}

export interface Route {
    id: number;
    number: string;
    date: string;
    spc: Spc;
    collector: Collector;
    car: Car;
}