import axios from 'axios';
import { useState, useEffect } from 'react';

const baseUrl = 'http://localhost:8080/api';
const deptsUrl = `${baseUrl}/departments`;
const empsUrl = `${baseUrl}/employees`;

function App() {
    const [emps, setEmps] = useState([]);
    const [depts, setDepts] = useState([]);

    useEffect(() => {
        (async () => {
            let resp = await axios.get(empsUrl);
            setEmps(resp.data);
        })();

        (async () => {
            let resp = await axios.get(deptsUrl);
            setDepts(resp.data);
        })();
    }, []);

    const empsJsx = emps.map((e) => (
        <tr key={e.id}>
            <td>{e.firstname}</td>
            <td>{e.lastname}</td>
            <td>{e.email}</td>
            <td>{e.phone}</td>
            <td>$ {e.salary}</td>
        </tr>
    ));

    const deptsJsx = depts.map((d) => (
        <tr key={d.id}>
            <td>{d.name}</td>
            <td>{d.location}</td>
        </tr>
    ));

    return (
        <>
            <div className='alert alert-primary'>
                <div className='container'>
                    <h1>Employee management system</h1>
                </div>
            </div>
            <div className='container'>
                <div className='row'>
                    <div className='col-7'>
                        <h2>Employee list</h2>
                        <table className='table table-bordered table-striped table-hover'>
                            <thead>
                                <tr>
                                    <th>Firstname</th>
                                    <th>Lastname</th>
                                    <th>Email id</th>
                                    <th>Phone number</th>
                                    <th>Salary</th>
                                </tr>
                            </thead>
                            <tbody>{empsJsx}</tbody>
                        </table>
                    </div>
                    <div className='col-5'>
                        <h2>Department list</h2>
                        <table className='table table-bordered table-striped table-hover'>
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Location</th>
                                </tr>
                            </thead>
                            <tbody>{deptsJsx}</tbody>
                        </table>
                    </div>
                </div>
            </div>
        </>
    );
}

export default App;
