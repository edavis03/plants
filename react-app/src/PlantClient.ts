import Plant from './plant'

const getPlants = () : Promise<Plant[]> => {
        return fetch('/plants').then(res => res.json());
};

export { getPlants };