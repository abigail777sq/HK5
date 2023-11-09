import { useEffect, useState } from "react";
import { fetchPersons } from "../../api/dataService"; // Asegúrate de tener la función fetchPersons en tu servicio de API.
import 'devextreme/data/odata/store';
import DataGrid, { Column } from 'devextreme-react/data-grid';

export default function Person() {
  const [personData, setPersonData] = useState();

  useEffect(() => {
    fetchPersons()
      .then((response) => {
        const personsData = response.data;

        console.log(personsData);

        setPersonData(personsData.map(person => ({
          id: person.id,
          name: person.name,
          groupCount: person.groups ? person.groups.length : 0
        })))
      })
      .catch((error) => {
        console.log(error);
      })
  }, []);

  return (
      <DataGrid
        dataSource={personData}
        showBorders={true}
      >
        <Column dataField="id" width={50} />
        <Column dataField="name" />
        {/* <Column dataField="groupCount" caption="Number of Groups" /> */}
      </DataGrid>
  )
}
