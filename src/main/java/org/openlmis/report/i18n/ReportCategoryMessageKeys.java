/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2017 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details. You should have received a copy of
 * the GNU Affero General Public License along with this program. If not, see
 * http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org.
 */

package org.openlmis.report.i18n;

public class ReportCategoryMessageKeys extends ReportingMessageKeys {
  private static final String ERROR = join(SERVICE_ERROR, "reportCategory");
  private static final String NAME = join(SERVICE_ERROR, "name");
  private static final String ID = "id";
  private static final String MISMATCH = "mismatch";
  private static final String DUPLICATED = join(SERVICE_ERROR, "duplicated");
  public static final String ERROR_REPORT_CATEGORY_NAME_DUPLICATED =
      join(ERROR, NAME, DUPLICATED);
  public static final String ERROR_REPORT_CATEGORY_NOT_FOUND = join(ERROR, NOT_FOUND);
  public static final String ERROR_REPORT_CATEGORY_ID_MISMATCH = join(ERROR, ID, MISMATCH);
  public static final String ERROR_CATEGORY_ASSIGNED = join(ERROR, "assigned");

}
