import React, { Component } from 'react';
import './App.css';

class App extends Component {
    state = {
        isLoading: true,
        days: []
    };

    async componentDidMount() {
        const response = await fetch('/fetch');
        const body = await response.json();
        this.setState({ days: body, isLoading: false });
    }

    render() {
        const {days, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
           // days.retroCalendarInventory.userDaysMap[11].retroDays
            JSON.stringify(this.state.days)
        );
    }
}

export default App;