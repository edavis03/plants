import React from 'react';
import { render, screen } from '@testing-library/react';
import { act } from 'react-dom/test-utils';
import PlantCollection from './PlantCollection'
import { getPlants } from './PlantClient'

jest.mock('./PlantClient');

describe('PlantCollection', () => {
    it('displays the names of the plants in the collection', async () => {

        const plants = [{"name":"violet"}, {"name":"aloe"}];
        getPlants.mockResolvedValue(plants);

        await act(async () => {
            render(<PlantCollection/>);
        })

        screen.getByText("violet");
        screen.getByText("aloe");
    });
});