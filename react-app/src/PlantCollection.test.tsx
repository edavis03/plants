import React from 'react';
import { render, screen } from '@testing-library/react';
import { act } from "react-dom/test-utils";
import axios from 'axios';
import PlantCollection from './PlantCollection'

jest.mock('axios');

describe('PlantCollection', () => {
    it('displays the names of the plants in the collection', async () => {

        const res = {data: [{"name":"violet"}, {"name":"aloe"}]};
        axios.get.mockResolvedValue(res);

        await act(async () => {
            render(<PlantCollection/>);
        })

        screen.getByText("violet");
        screen.getByText("aloe");
    });
});