import 'react-app-polyfill/ie11';
import 'react-app-polyfill/stable';

import React from 'react';
import ReactDOM from 'react-dom';
import './style/index.css';
import App from './components/App';
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';

ReactDOM.render(<App />, document.getElementById('root'));

serviceWorker.unregister();
