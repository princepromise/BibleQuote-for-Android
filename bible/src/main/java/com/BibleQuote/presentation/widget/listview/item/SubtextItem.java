/*
 * Copyright (C) 2011 Scripture Software
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Project: BibleQuote-for-Android
 * File: SubtextItem.java
 *
 * Created by Vladimir Yakushev at 10/2017
 * E-mail: ru.phoenix@gmail.com
 * WWW: http://www.scripturesoftware.org
 */

package com.BibleQuote.presentation.widget.listview.item;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.BibleQuote.R;
import com.BibleQuote.presentation.widget.listview.itemview.ItemView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class SubtextItem extends TextItem {

	/**
	 * The string that will be displayed above the title of the item (possibly
	 * on several lines).
	 */
	public String subtext;

	/**
	 * @hide
	 */
	public SubtextItem() {
		this(null);
	}

	/**
	 * @hide
	 */
	public SubtextItem(String text) {
		this(text, null);
	}

	/**
	 * Constructs a new SubtextItem
	 *
	 * @param text    The main text for this item
	 * @param subtext The subtext
	 */
	public SubtextItem(String text, String subtext) {
		super(text);
		this.subtext = subtext;
	}

	@Override
	public ItemView newView(Context context, ViewGroup parent) {
		return createCellFromXml(context, R.layout.subtext_item_view, parent);
	}

	@Override
	public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
		super.inflate(r, parser, attrs);

		TypedArray a = r.obtainAttributes(attrs, R.styleable.SubtextItem);
		subtext = a.getString(R.styleable.SubtextItem_subtext);
		a.recycle();
	}

}
