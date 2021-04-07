import React from 'react';
import axios from 'axios';

type Plant = {
    name: string;
};

const PlantCollection = () => {
    const [plantList, setPlantList] = React.useState<Plant[]>([]);

    React.useEffect(() => {
        const fetchData = async () => {
            const res = await axios.get('/plants');
            const stuff = res.data.map((d: any) => ({ name: d.name }));
            await setPlantList(stuff);
        }
        fetchData();
      }, []);

    return (
        <div data-testid='plant-collection'>
            {plantList.map((d, i) => <div key = {i}> {d.name} </div>)}
        </div>
    );
};

export default PlantCollection;