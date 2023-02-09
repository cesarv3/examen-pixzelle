import React,{useEffect, useState} from 'react'
import axios from 'axios';
import Col from  'react-bootstrap/Col';
import Row from  'react-bootstrap/Row';
import Juego from '../juego/Juego'
import AgregarJuego from '../partials/modal-agregar-juego/Agregar-Juego';
import Navbar from '../partials/navbar/Navbar';


const Contenido = () => {
    const url = 'http://localhost:8080/juego/all';
    const [juegos,setJuegos] = useState([]);    
    const [isOpen,setOpen] = useState(false);


useEffect(() => {
    getJuegos();
},[]);

const getJuegos = async () => {
    const respuesta = await axios.get(url);
    setJuegos(respuesta.data._embedded.juegoDataList);
}

//function Grid() {
    return(
            <div className='container-fluid'>
                <Navbar/>
                <div className='row mt-3'>                    
                    <Row xs={1}  md={3} lg={4} className="g-4">
                    {juegos.map((juego,id) => (                    
                        
                            <Col><Juego key={juego.id}
                    imagen={juego.imagen}
                    nombre={juego.nombre}
                    descripcion={juego.descripcion}
                    id={juego.juego_id}/></Col>                                            
                ))}
                
                </Row>
                {isOpen && <AgregarJuego closeModal={setOpen}/>}
                </div>                
                 
            
            </div>
    )
}

export default Contenido;