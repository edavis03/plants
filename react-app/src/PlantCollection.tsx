import React from 'react';
import axios from 'axios';

const PlantCollection = () => {
    const [plantList, setPlantList] = React.useState(null);

    React.useEffect(() => {
        const fetchData = async () => {
            const res = await axios.get('/plants');
            await setPlantList(res.data);
        }
        fetchData();
      }, []);

    return (
        <div data-testid='plant-collection'>
            { plantList &&
             (plantList.map(
                (plant, i) => (<div key={i}> {plant.name} </div>)))
            }
        </div>
    );
};

export default PlantCollection;