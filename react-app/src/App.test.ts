import { render } from '@testing-library/react';
import App from './App';

describe('App', () => {

    it('displays a plant collection', () => {
        const { queryByTestId } = render(<App/>);
        console.log(queryByTestId);
        expect(queryByTestId('plant-collection')).toBeTruthy(); //I kind of hate this
    });
});
