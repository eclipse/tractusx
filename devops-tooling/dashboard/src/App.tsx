import React from 'react';
import './App.scss';
import Dashboard from './components/Dashboard/Dashboard';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        Force Graph Example
      </header>
      <section className="Main">
        <Dashboard />
      </section>
  </div>
  );
}

export default App;
