/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.html
 * 
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipsescout.demo.minifigcreator.shared.services.process;

import javax.annotation.Generated;

import org.eclipse.scout.commons.annotations.ClassId;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.fields.tablefield.AbstractTableFieldData;
import org.eclipsescout.demo.minifigcreator.shared.minifig.part.Part;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 * 
 * @generated
 */
@Generated(value = "org.eclipse.scout.sdk.workspace.dto.formdata.FormDataDtoUpdateOperation", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class ServerFormData extends AbstractFormData {

  private static final long serialVersionUID = 1L;

  public ServerFormData() {
  }

  public Table getTable() {
    return getFieldByClass(Table.class);
  }

  @ClassId("SERVFORM_TABLE_TBLFLD-formdata")
  public static class Table extends AbstractTableFieldData {

    private static final long serialVersionUID = 1L;
    public static final int PART_COLUMN_ID = 0;
    public static final int TYPE_COLUMN_ID = 1;
    public static final int NAME_COLUMN_ID = 2;
    public static final int QUANTITY_COLUMN_ID = 3;

    public Table() {
    }

    public String getName(int row) {
      return (String) getValueInternal(row, NAME_COLUMN_ID);
    }

    public void setName(int row, String name) {
      setValueInternal(row, NAME_COLUMN_ID, name);
    }

    public Part getPart(int row) {
      return (Part) getValueInternal(row, PART_COLUMN_ID);
    }

    public void setPart(int row, Part part) {
      setValueInternal(row, PART_COLUMN_ID, part);
    }

    public Integer getQuantity(int row) {
      return (Integer) getValueInternal(row, QUANTITY_COLUMN_ID);
    }

    public void setQuantity(int row, Integer quantity) {
      setValueInternal(row, QUANTITY_COLUMN_ID, quantity);
    }

    public String getType(int row) {
      return (String) getValueInternal(row, TYPE_COLUMN_ID);
    }

    public void setType(int row, String type) {
      setValueInternal(row, TYPE_COLUMN_ID, type);
    }

    @Override
    public int getColumnCount() {
      return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
      switch (column) {
        case PART_COLUMN_ID:
          return getPart(row);
        case TYPE_COLUMN_ID:
          return getType(row);
        case NAME_COLUMN_ID:
          return getName(row);
        case QUANTITY_COLUMN_ID:
          return getQuantity(row);
        default:
          return null;
      }
    }

    @Override
    public void setValueAt(int row, int column, Object value) {
      switch (column) {
        case PART_COLUMN_ID:
          setPart(row, (Part) value);
          break;
        case TYPE_COLUMN_ID:
          setType(row, (String) value);
          break;
        case NAME_COLUMN_ID:
          setName(row, (String) value);
          break;
        case QUANTITY_COLUMN_ID:
          setQuantity(row, (Integer) value);
          break;
      }
    }
  }
}