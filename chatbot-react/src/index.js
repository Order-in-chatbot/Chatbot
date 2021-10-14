import React, {Suspense, lazy} from 'react';
import ReactDOM from 'react-dom';
import {Route, Switch,HashRouter as Router} from 'react-router-dom';
const App=()=>{
	const Main=lazy(()=>import('./main/jsx/mainPage'));
	const SulbingChat=lazy(()=>import('./main/jsx/sulbingChat'));
	const McChat=lazy(()=>import('./main/jsx/mcChat'));
	const GongchaChat=lazy(()=>import('./main/jsx/gongchaChat'));
	return(
	<Router>
		<Suspense fallback={<div>Loading...</div>}>
			<Switch>
				//page추가시 여기서 넣기
				<Route path="/" exact component={Main}/>
				<Route path="/sulbing" exact component={SulbingChat}/>
				<Route path="/mcdonalds" exact component={McChat}/>
				<Route path="/gongcha" exact component={GongchaChat}/>
			</Switch>
		</Suspense>
	</Router>
	);
};
ReactDOM.render(<App/>, document.getElementById("app"));