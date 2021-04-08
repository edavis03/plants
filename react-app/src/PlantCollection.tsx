import React from 'react';
import axios from 'axios';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';


type Plant = {
    name: string;
};

const PlantCollection = () => {
    const [plantList, setPlantList] = React.useState<Plant[]>([]);

    React.useEffect(() => {
        const fetchData = async () => {
            const res = await axios.get('/plants');
            const fetchedPlants = res.data.map((d: any) => ({ name: d.name }));
            await setPlantList(fetchedPlants);
        }
        fetchData();
      }, []);

    return (
        <div data-testid='plant-collection'>
            {plantList.map((d, i) =>
                <Card key={i} variant="outlined">
                    <CardContent>
                        {d.name}
                    </CardContent>
                </Card>
            )}
        </div>
    );
};

export default PlantCollection;