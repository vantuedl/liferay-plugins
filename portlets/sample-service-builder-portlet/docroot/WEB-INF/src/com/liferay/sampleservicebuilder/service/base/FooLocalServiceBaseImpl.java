/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.sampleservicebuilder.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.liferay.sampleservicebuilder.model.Foo;
import com.liferay.sampleservicebuilder.service.FooLocalService;
import com.liferay.sampleservicebuilder.service.persistence.FooPersistence;
import com.liferay.sampleservicebuilder.service.persistence.FooUtil;

import java.util.List;

/**
 * <a href="FooLocalServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class FooLocalServiceBaseImpl implements FooLocalService {
	public Foo addFoo(Foo foo) throws SystemException {
		foo.setNew(true);

		return fooPersistence.update(foo, false);
	}

	public void deleteFoo(long fooId) throws PortalException, SystemException {
		fooPersistence.remove(fooId);
	}

	public void deleteFoo(Foo foo) throws SystemException {
		fooPersistence.remove(foo);
	}

	public List<Foo> dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return fooPersistence.findWithDynamicQuery(dynamicQuery);
	}

	public List<Foo> dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return fooPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	public Foo getFoo(long fooId) throws PortalException, SystemException {
		return fooPersistence.findByPrimaryKey(fooId);
	}

	public Foo updateFoo(Foo foo) throws SystemException {
		foo.setNew(false);

		return fooPersistence.update(foo, true);
	}

	public FooPersistence getFooPersistence() {
		return fooPersistence;
	}

	public void setFooPersistence(FooPersistence fooPersistence) {
		this.fooPersistence = fooPersistence;
	}

	protected void init() {
		if (fooPersistence == null) {
			fooPersistence = FooUtil.getPersistence();
		}
	}

	protected FooPersistence fooPersistence;
}