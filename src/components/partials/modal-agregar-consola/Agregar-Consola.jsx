import React, { useState } from 'react'
import Button from 'react-bootstrap/Button';
import CloseButton from 'react-bootstrap/CloseButton';
import axios from 'axios';
import "./Agregar-Consola.css"
import { mostrar_alerta } from '../../../funciones';


function AgregarConsola({selectedConsola, metodoId, closeModal, loadConsola}){
    let url = '';    
    const [nuevoObj, setNuevoObj] = useState(selectedConsola)     

    const validar = () => {
        var parametros;
        var metodo;                
        
        if(nuevoObj.nombre.trim() === ''){
            mostrar_alerta('Escribe el nombre de la consola','warning');
        } else {
            if(metodoId == 0){
                url = 'http://localhost:8080/consola/create';
                parametros = {nombre: nuevoObj.nombre};
                metodo = 'POST';
            } else if(metodoId == 1){
                url = 'http://localhost:8080/consola/'+nuevoObj.consola_id;
                parametros = {nombre: nuevoObj.nombre};
                metodo = 'PUT';
            }
            
            enviarSolicitud(metodo,parametros);
        }
    }

    const enviarSolicitud = async(metodo, parametros) => {
        await axios({method: metodo, url: url, data:parametros}).then(function(respuesta){
            if(respuesta.data){
                if(metodoId == 0){
                mostrar_alerta("Elemento creado con éxito",'success');
            } else if(metodoId == 1){
                mostrar_alerta("Elemento actualizado con éxito",'success');
            }
            {loadConsola()};
            }                        
        })
        .catch(function(error){
            mostrar_alerta("Error en la solicitud",'error');
            console.log(error);
        })
    }


    return (
        <div id='modalConsola' className='modalBackground'>            
            <div className='modalContainer'>                
                <div className='titleCloseBtn'>  
                <CloseButton  onClick={() => {
                        closeModal(false)}}></CloseButton>                                                      
                </div>
                <div className='title'>                    
                <h2>{metodoId == 0 ? 'Agregar' : 'Editar'} Consola</h2>
                </div>
                <div className='body'>
                    <form>
                    
                    <input type='text' id='consola' placeholder='Nombre'
                    onChange={(e) => setNuevoObj({...nuevoObj, nombre: e.target.value} )} value={nuevoObj.nombre} ></input>                    
                    
                    <div className='footer'>
                    <Button id='addBtn' onClick={() => validar()} type='button'>{metodoId == 1 ? 'Editar' : 'Agregar'}</Button>
                    </div>
                    </form>
                </div>
                
            </div>
        </div>
    )
}

export default AgregarConsola;