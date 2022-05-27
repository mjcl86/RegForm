import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Home from 'pages/Home';
import Formacoes from 'pages/Formacoes';
import Alunas from 'pages/Alunas';
import Navbar from "components/Navbar";
import SideBar from 'components/SideBar';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <SideBar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/formacoes">
          <Route path=":formId" element={<Formacoes />} />
        </Route>
        <Route path="/alunas">
          <Route path=":alunasId" element={<Alunas />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;