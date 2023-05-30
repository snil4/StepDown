import { render } from 'preact';
import './index.css';
import Main from './Components/MainArea/Main/Main';
import "preact/debug";
import { BrowserRouter } from 'react-router-dom';
import Routing from './Components/Shared/Routing/Routing';

render(<BrowserRouter><Routing/></BrowserRouter>, document.getElementById('app') as HTMLElement);
