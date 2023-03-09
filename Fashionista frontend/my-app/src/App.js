import { BrowserRouter, Switch, Route } from 'react-router-dom';
import NotFound from './components/NotFound';
import 'bootstrap/dist/css/bootstrap.min.css';
import UserList from './components/User/UsersList';
import AddUser from './components/User/AddUser';
import Footer from './components/Footer';
import Whoarewe from './components/Whoarewe';
import Faq from './components/Faq';
import ContactUs from './components/ContactUs';

function App() {
  return (

    <BrowserRouter>
      <div>
        <div>
          <Switch>
            
          <Route exact path="/a" component={Footer} />
          <Route exact path="/Whoarewe" component={Whoarewe}/>
          <Route exact path="/Faq" component={Faq}/>
          <Route exact path="/ContactUs" component={ContactUs}/>
            
            <Route exact path="/" component={UserList} />
            <Route path="/add" component={AddUser} />
            <Route path="/users/edit/:id" component={AddUser} />
            <Route path="*" component={NotFound} />
          </Switch>
        </div>
      </div>
    </BrowserRouter>
  );
}


export default App;
