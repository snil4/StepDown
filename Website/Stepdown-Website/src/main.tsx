import { render } from 'preact';
import './index.css';
import Main from './Components/MainArea/Main/Main';
import "preact/debug";

render(<Main/>, document.getElementById('app') as HTMLElement);
