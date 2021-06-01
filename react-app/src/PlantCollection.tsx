import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import { getPlants } from './PlantClient'
import Plant from './plant'

const PlantCollection = () => {
    const [plantList, setPlantList] = React.useState<Plant[]>([]);

    React.useEffect(() => {
        const fetchData = async () => {
            const res = await getPlants();
            const fetchedPlants = res.map((d: any) => ({ name: d.name }));
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