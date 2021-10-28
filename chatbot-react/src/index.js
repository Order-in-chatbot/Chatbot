import React, {Suspense, lazy} from 'react';
import ReactDOM from 'react-dom';
import {Route, Switch,HashRouter as Router} from 'react-router-dom';
const App=()=>{
	const Main=lazy(()=>import('./main/jsx/mainPageContainer'));
	const StoreChat=lazy(()=>import('./main/jsx/storeChat'));
	return(
	<Router>
		<Suspense fallback={<div>Loading...</div>}>
			<Switch>
				<Route path="/" exact component={Main}/>
				<Route path="/storechat" exact component={StoreChat}/>
			</Switch>
		</Suspense>
	</Router>
	);
};
ReactDOM.render(<App/>, document.getElementById("app"));